package com.zhongran.purchase.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongran.purchase.dao.GroupBasicCountDao;
import com.zhongran.purchase.dao.GroupBasiceDao;
import com.zhongran.purchase.dao.QualityIndexDao;
import com.zhongran.purchase.dao.ResultDao;
import com.zhongran.purchase.entity.GroupBasic;
import com.zhongran.purchase.entity.GroupBasicCount;
import com.zhongran.purchase.entity.QualityIndex;
import com.zhongran.purchase.entity.Result;
import com.zhongran.purchase.service.ResultService;
import com.zhongran.purchase.util.UUIDHexGenerator;
@Service
public class ResultServiceImpl implements ResultService{
   @Autowired
   ResultDao resultDao;
   @Autowired
   QualityIndexDao qualityIndexDao;
   @Autowired
   GroupBasiceDao groupBasiceDao;
   @Autowired
   GroupBasicCountDao groupBasicCountDao;
   private static double resultDouble=0;
   private static int[] resultArray;
   private static List<GroupBasic> listRes;
   private static double countTj;//总体积
   private static double vismassPrec;//
   public static double getCountTj() {
	return countTj;
}

 

public static double getVismassPrec() {
	return vismassPrec;
}



public static void setVismassPrec(double vismassPrec) {
	ResultServiceImpl.vismassPrec = vismassPrec;
}



public static void setCountTj(double countTj) {
	ResultServiceImpl.countTj = countTj;
}

public static List<GroupBasic> getListRes() {
	return listRes;
}

public static void setListRes(List<GroupBasic> listRes) {
	ResultServiceImpl.listRes = listRes;
}

public static int[] getResultArray() {
	return resultArray;
}

public static void setResultArray(int[] resultArray) {
	ResultServiceImpl.resultArray = resultArray;
}

public static double getResultDouble() {
	return resultDouble;
}

public static void setResultDouble(double resultDouble) {
	ResultServiceImpl.resultDouble = resultDouble;
}
private static List<int[]>  resultCount;
   
	public static List<int[]> getResultCount() {
	return resultCount;
}

	public  void setResultCount(List<int[]> resultCount) {
		this.resultCount = resultCount;
	}

	@Override
	public List<Result> getAll() {
		return resultDao.getAll();
	}

	@Override
	public void insert(Result res) {
		resultDao.insert(res);
	}

	@Override
	public List<Result> getAllP(String docnum) {
		return resultDao.getAllP(docnum);
	}
 
	
	public void inserAll(String ids, List<QualityIndex> qualityindex,String docNum) {
        SimpleDateFormat simple=new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		setResultArray(null);
		setResultDouble(0);
		setCountTj(0);
		System.out.println(simple.format(System.currentTimeMillis()));
		 String ida[]=ids.split(",");
		 UUIDHexGenerator uuidHexGenerator = new UUIDHexGenerator();
		 List<GroupBasic> list=new ArrayList<GroupBasic>();
		 for(String id:ida){
			  list.add(groupBasiceDao.getOne(id));
			  
		  }
		 setListRes(list);
		 for(QualityIndex obj:qualityindex){//这里是条件
			 obj.setDocNum(docNum);
			 obj.setId(uuidHexGenerator.generate());
			 qualityIndexDao.insert(obj);
		 }
		 split(new int[getListRes().size()], 100, getListRes().size(),qualityindex);
		 
		 System.out.println("最低成本"+getResultDouble()/100);
		 if(null!=getResultArray()){
			 for(int i=0;i<getResultArray().length;i++){
				 double ton=getResultArray()[i];
				 GroupBasicCount basciCount=new GroupBasicCount();
				 basciCount.setId(uuidHexGenerator.generate());
				 basciCount.setDocNum(docNum);//生产编号
				 basciCount.setTon(ton);//吨数
				 basciCount.setBasicId(getListRes().get(i).getId());//质量基础数据id
				 basciCount.setMixCost(getListRes().get(i).getStorageMoney()*ton/100);//混合后成本
				 basciCount.setMassprec(ton/100);//计算质量百分比
				 double tj=ton/getListRes().get(i).getMd();//计算单个体积
				 basciCount.setVolume(tj); 
				 basciCount.setVoluMeprec(tj/getCountTj());//计算体积百分比
				 if(getListRes().get(i).getMotionTemp()==50){//获得粘度温度
					 basciCount.setHotCorrect(0);
				 }else if(getListRes().get(i).getMotionTemp()==20){
					 basciCount.setHotCorrect(-4.9);
				 }else if(getListRes().get(i).getMotionTemp()==40){
					 basciCount.setHotCorrect(-1.6);
				 }else if(getListRes().get(i).getMotionTemp()==100){
					 basciCount.setHotCorrect(-17.2);
				 }else{
					 
				 }
				 double nd=getListRes().get(i).getMotionvIs()+0.85;//运动粘度
				 double visCosity =Math.log10(Math.log10(nd))*33.5+19.2+basciCount.getHotCorrect();//修正后粘度系数
				 basciCount.setVisCosity(visCosity);
				 double a=basciCount.getMassprec()*visCosity;
				 basciCount.setVisMassprec(a);//修正后的粘度与质量系数
				 basciCount.setVisMassprec(a*ton/100);//混合后粘度
 				 groupBasicCountDao.insert(basciCount);
				 System.out.println("【"+getListRes().get(i).getGroupName()+"="+getResultArray()[i]+"】");
			 }
		 }
		 
		 System.out.println(simple.format(System.currentTimeMillis()));
	}

	  
	    private static  void split(int[] result, int n, int num,List<QualityIndex> qualityindex){
	        if(2==num){
	            for(int i=0;i<=n;i++){
	                result[result.length-num]=i;
	                result[result.length-num+1]=n-i;
	                countResult(result,qualityindex);
	            }
	            return ;
	        }
	        else{
	            for(int i=0;i<=n;i++){
	                result[result.length-num]=i;
	                split(result, n-i, num-1,qualityindex);
	            }
	        } 
	}
	  //根据组合计算成本
		public static void countResult(int result[],List<QualityIndex> qualityindex){
			double count=0;
			double lhl=0;
			double hot=0;
			double tj=0;
			double wdxzxs = 0;
			double vismassPrec=0;
			 //for(int r:result){//组合等于100
				 List<GroupBasic> dataList=getListRes();
				 for(int i=0;i<dataList.size();i++){//循环基础数据
					 if(result[i]==0){
						 continue;
					 }
					 count+=dataList.get(i).getStorageMoney()*result[i];//计算成本
					 lhl+=dataList.get(i).getSulfurCon()*result[i]/100;
					 hot+=dataList.get(i).getNethot()*result[i]/100;
					 tj+=result[i]/dataList.get(i).getMd();//计算总体积 总质量/混合后密度
					  if(getListRes().get(i).getMotionTemp()==50){//获得粘度温度
						 wdxzxs=0;
					 }else if(getListRes().get(i).getMotionTemp()==20){
						 wdxzxs=-4.9;
					 }else if(getListRes().get(i).getMotionTemp()==40){
						 wdxzxs=-1.6;
					 }else if(getListRes().get(i).getMotionTemp()==100){
						 wdxzxs=7.2;
					 }else{
						 
					 } 
					 double nd=getListRes().get(i).getMotionvIs()+0.85;//运动粘度
					 double visCosity =Math.log10(Math.log10(nd))*33.5+19.2+wdxzxs;//修正后粘度系数
					 vismassPrec+=(visCosity*result[i]/100);//修正后的粘度和质量系数
				 }
				 //混合后密度=100吨除以总体积
			  double md=100 /tj ;
			 //}
			 /* if(checkReuslt(qualityindex,md) && checkReuslt(qualityindex,lhl) && checkReuslt(qualityindex,hot)){
				  comPareResult(count,result);
			  }*/
			  boolean falg=false;
			  for(QualityIndex qindex :qualityindex){
				  if(qindex.getQuaitid()==1 && qindex.getCost()>0){//id 为1表示混合后密度
					   Double dou1=new Double(md);
					   Double dou2=new Double(qindex.getCost());
					   if(qindex.getOptioinCode().equals("<=") ){
						   if(dou1.compareTo(dou2)<=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
					   if(qindex.getOptioinCode().equals(">=") ){
						   if(dou1.compareTo(dou2)>=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
				  }
				  if(qindex.getQuaitid()==2 && qindex.getCost()>0){//id 为2表示混合后硫含量
					   Double dou1=new Double(lhl);
					   Double dou2=new Double(qindex.getCost());
					   if(qindex.getOptioinCode().equals("<=") ){
						   if(dou1.compareTo(dou2)<=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
					   if(qindex.getOptioinCode().equals(">=") ){
						   if(dou1.compareTo(dou2)>=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
				  }
				  if(qindex.getQuaitid()==3 && qindex.getCost()>0){//id 为3表示混合后粘度
					  double vismassPrecCount=Math.pow(10, Math.pow(10, (vismassPrec-19.2)/33.5))-0.85;
					   Double dou1=new Double(vismassPrecCount);
					   Double dou2=new Double(qindex.getCost());
					   if(qindex.getOptioinCode().equals("<=") ){
						   if(dou1.compareTo(dou2)<=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
					   if(qindex.getOptioinCode().equals(">=")){
						   if(dou1.compareTo(dou2)>=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
				  }
				  if(qindex.getQuaitid()==4 && qindex.getCost()>0){//id 为4表示混合后净热值
					   Double dou1=new Double(hot);
					   Double dou2=new Double(qindex.getCost());
					   if(qindex.getOptioinCode().equals("<=") ){
						   if(dou1.compareTo(dou2)<=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
					   if(qindex.getOptioinCode().equals(">=") ){
						   if(dou1.compareTo(dou2)>=0){
							   falg=true;
							   continue;
						   }else{
							   falg=false;
							   break;
						   }
					   }
				  }
			  }
			  if(falg){
				  comPareResult(count,tj,result);
			  }
			 /*if( md <= 980 && lhl <= 0.5 && hot >= 9400 ){
				  
				 comPareResult(count,result);
			 }*/
		}
		//对指标进行判断
		public static boolean checkReuslt(List<QualityIndex> qualityindex,double value){
			
			boolean falg=false;
			 return falg;
		}
		public static void comPareResult(double newResult,double tj,int result[]){
			if(resultDouble==0){
				 setResultDouble(newResult);
				 setCountTj(tj);
				 setResultArray(result.clone());
			}else{
				if(Double.compare(newResult,resultDouble)<0){
					 //resultDouble=newResult;
					 setResultDouble(newResult);
					 setResultArray(result.clone());
					 setCountTj(countTj);
					 //setVismassPrec(vismassPrec);//混合后粘度
					 //setListRes(listRes);
				 }
			}
		}
}
