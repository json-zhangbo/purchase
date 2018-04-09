package com.zhongran.purchase.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhongran.purchase.entity.GroupBasic;
import com.zhongran.purchase.entity.Qresult;
import com.zhongran.purchase.entity.QualityIndex;
import com.zhongran.purchase.entity.Result;
import com.zhongran.purchase.service.GroupBasicCountService;
import com.zhongran.purchase.service.GroupBasicService;
import com.zhongran.purchase.service.QresultService;
import com.zhongran.purchase.service.QualityIndexService;
import com.zhongran.purchase.service.ResultService;
import com.zhongran.purchase.util.UUIDHexGenerator;
import com.zhongran.purchase.vo.GroupBasicAndCount;
import com.zhongran.purchase.vo.QresultAll;

@RestController  
@RequestMapping("/groupBasic") 
public class GroupBasicController {
	  @Autowired
	  private GroupBasicService groupBasicService;
	  @Autowired
	  private ResultService resultService;
	  @Autowired
	  private QresultService qresultService;
	  @Autowired
	  QualityIndexService qualityIndexService;
	  @Autowired
	  GroupBasicCountService groupBasicCountService;
	  
	  @RequestMapping(value="/basic",method = RequestMethod.POST)
	    public String groupBasic(HttpServletResponse response,GroupBasic groupBasic){
		  UUIDHexGenerator uuidHexGenerator = new UUIDHexGenerator();
	        String generate = uuidHexGenerator.generate();
	        groupBasic.setId(generate);
		  groupBasicService.insertBasicEntity(groupBasic);
		  try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		  return "success";
	    }
	  @RequestMapping(value="/all",method = RequestMethod.GET)
	    public List<GroupBasic> groupBasicAll(){
		  
	    	return groupBasicService.getAll();
	    }
	  @RequestMapping(value="/result/{docnum}",method=RequestMethod.GET)
	  public List<Result> getAllResult(@PathVariable String docnum){
		  
		  return resultService.getAllP(docnum);
	  }
	  @RequestMapping(value="/result/count/{docnum}",method=RequestMethod.GET)
	  public List<GroupBasicAndCount> getAllResultCount(@PathVariable String docnum){
		  
		  return groupBasicCountService.getByDocNum(docnum);
	  }
	  @RequestMapping(value="/result/{ids}",method=RequestMethod.POST)
	  public String addBasicId(@PathVariable String ids,HttpServletRequest request,@RequestBody List<QualityIndex> qualityindex){
		 //HttpServletRequest request
		  System.out.println("-------"+qualityindex.size()+request.getParameterValues("optioinCode"));
		  for(QualityIndex a:qualityindex){
			  System.out.println("cost=="+a.getCost());
		  }
		  UUIDHexGenerator uuidHexGenerator = new UUIDHexGenerator();
	      String docNum = uuidHexGenerator.generate();
	      resultService.inserAll(ids, qualityindex, docNum);
	      //resultService.countResult(ids, qualityindex);
	      
		  return docNum;
	  }
	  @RequestMapping(value="/qresult",method=RequestMethod.GET)
	  public List<Qresult> getAllQResult(){
		  
		  return qresultService.getAll();
	  }
	  @RequestMapping(value="/qresultAll",method=RequestMethod.GET)
	  public List<QresultAll> getAllQResultAll(){
		  
		  return qresultService.getAllP();
	  }
}
