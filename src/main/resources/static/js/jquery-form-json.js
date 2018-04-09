$.extend({
    frmtJson: function(dataArray,columsLength) {
         var res=[];
         var len=dataArray.length/columsLength;//行长度
          var index=1;
         for(var i=0;i<len;i++){//循环有多少行
        	 var obj=new Object();
        	  for(var j=0;j<columsLength;j++){//循环列数,0,1,2   
        		  var resIndex=i*columsLength+j;
        		  var val=dataArray[resIndex].value;
        		  switch (j){
        		  case 0: 
        			  obj.quaitid=val;
        			  break;
        		  case 1:
        			  obj.optioinCode=val;
        			  break;
        		  case 2:
        			  obj.cost=val;
        			  break;
        		  default: 
        			  console.log('找不到默认值');
        			  break;
        		  }
        		 /* if(j ==(columsLength-1)){
        			  obj.dataArray[resIndex].name=dataArray[resIndex].value;
        			  objStr+=dataArray[resIndex].name+':"'+dataArray[resIndex].value+'"';
        		  }else{
        			  objStr+=dataArray[resIndex].name+':"'+dataArray[resIndex].value+'",';
        		  }*/
        	  }
        	  res.push(obj);
        	  index++;
         }
         console.log(res);
    	 /*for(var i=0;i<dataArray.length/columsLength;i+columsLength){
    		 console.log(dataArray[i]);
    		 //res.push({dataArray[i].name:dataArray[i].name,dataArray[i+1].name:dataArray[i+1].name});
    	 }*/
    	 return res;
    }
});