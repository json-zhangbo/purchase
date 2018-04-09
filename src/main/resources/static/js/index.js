$(function () {
	/*$('#addCon').click(function(){
		   var data = {};
           $('#tableCond').bootstrapTable('append',data);    
	});*/
	$('#startCount').click(function(){
		//sortRowsData();
		getSelectTab();
	});
	 
	$("#tableCond").bootstrapTable({
            height:'100%',
            url:'/purchase/groupBasic/qresult',
            uniqueId        : 'id',                     // 绑定ID  
            dataType: "json",
            columns: [{
                field: 'id',
                title: '序号',
                formatter: function (value, row, index) {  
                    return index+1;  
                }
            }, {
                field: 'quaGroupname',
                title: '指标名称'/*,
                editable:true,
                formatter: function (value, row, index) {  
               	 
                	var sel='<select name="quaGroupname"><option value="">请选择</option><option value="MIXINGDEN">混合后密度</option><option value="MIXSULFURCONT">混合后硫含量</option><option value="VISCOSITY">混合后粘度</option><option value="MIXHOT">混合后净热值</option></select>';
                    return sel;  
                }*/
            },{
                field: 'fdName',
                title: '字段名称'
            },{
                field:'optioinCode',
                title: '条件',
                formatter: function (value, row, index) {  
                	var quaitid='<input type="hidden" name="quaitid" value="'+row.id+'"></input>';
                	 
                	var sel='<select name="optioinCode"><option value="">请选择</option><option value="\>=">>=</option><option value="<="><=</option></select>';
                    return quaitid+sel;  
                }
            }, {
                field:'cost',
                title: '结果',
                formatter: function (value, row, index) {  
                	var sel='<input type="text" name="cost"></input>';
                	//var fdName='<input type="hidden" name="quaitid" value="'+row.fdName+'"></input>';
                    return sel;  
                }
            }]
});
$('#resultTb').bootstrapTable({
	 url:'/purchase/groupBasic/result/111',
	 uniqueId : 'id',                     // 绑定ID  
     dataType: "json",
     pagination:true,
     striped: true,  
     pageSize:10,
     pageNumber:1,
     singleSelect: true, 
     showRefresh : true,                     // 显示刷新按钮  
     showColumns     : true,                     // 选择显示的列  
     width:'100%',
     sidePagination:'client',
     paginationLoop:true,
     checkbox:true,
     toolbar:'#tooblarTbTon',
     columns:[{
  	   field: 'id',
	   title: '序号',//标题  可不加  
       formatter: function (value, row, index) {  
           return index+1;  
       }},
       {
      	   field: 'groupName',
    	   title: '组份名称'
    },
    {field: 'cost',title: '混合后成本'},
    {field: 'ton',title: '吨数'}/*,
    {field: 'maxTon',title: '最大吨数'}*/
    ],
    onLoadSuccess:function(data){
    	var count=0;
    	$.each(data,function(i,v){
    		count+=eval(v.cost*v.ton/100);
    	});
    	$('#resultSPan').html(count);
    }
});
$('#tableDb').bootstrapTable({
	       url:"/purchase/groupBasic/all",
	       uniqueId: 'id',                     // 绑定ID  
	       dataType: "json",
	       pagination:true,
	       striped: true,  
	       pageSize:10,
	       pageNumber:1,
	       showRefresh : true,                     // 显示刷新按钮  
	       showColumns     : true,                     // 选择显示的列  
	       width:'100%',
	       sidePagination:'client',
	       paginationLoop:true,
	       checkbox:true,
	       toolbar:'#tooblarTb',
	       clickToSelect : true, //是否启用点击选中行
	       onCheck:function(row){
	    	   
	       },
           columns: [{
               align : 'center',
               checkbox: true,                          // 显示复选框
               formatter: function (i,row) {            // 每次加载 checkbox 时判断当前 row 的 id 是否已经存在全局 Set() 里
                   
               }  
           },{

        	   field: 'id', 
        	   title: '序号',//标题  可不加  
               formatter: function (value, row, index) {  
                   return index+1;  
               }  
            }, {
                field: 'groupName', 
                title: '组份名称'
            }, {
                field: 'storageMoney',
                title: '入库成本'
            }, {
                field: 'motionvIs',
                title: '运动粘度'
            }, {
                field: 'sulfurCon',
                title: '硫含量'
            }, {
                field: 'nethot',
                title: '净热值'
            }, {
                field: 'motionTemp',
                title: '粘度温度'
            }, {
                field: 'md',
                title: '密度'
            }],
            onPostBody:function(){
            	//$('.switch').bootstrapSwitch('setState',false);//注意是setState
            }
        });

    $('#myModal').on('hide.bs.modal', function () {
         window.location.reload();
    });
    $('#myModal').on('shown.bs.modal', function (e) { 
        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零  
       /* $(this).css('display', 'block');  
        var modalHeight=$(window).height() / 2 - $('#youModel .modal-dialog').height() / 2;  
        $(this).find('.modal-dialog').css({  
            'margin-top': modalHeight  
        }); */ 
	    /*var $this = $(this);
	    var $modal_dialog = $this.find('.modal-dialog');
	    var m_top = ( $(window).height() - $modal_dialog.height() )/2;
	    $modal_dialog.css({'margin': m_top + 'px auto'});*/
	    
    });  
    $('#add-regular').click(function(){

		$.gritter.add({
			// (string | mandatory) the heading of the notification
			title: 'This is a regular notice!',
			// (string | mandatory) the text inside the notification
			text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
			// (string | optional) the image to display on the left
			image: 'img/avatar.jpg',
			// (bool | optional) if you want it to fade out on its own or just sit there
			sticky: false,
			// (int | optional) the time you want it to be alive for before fading out
			time: ''
		});

		return false;
	});
    });
//选择的数据按照成本进行排序
function sortRowsData(){
	var arr=$('#tableDb').bootstrapTable('getSelections');
	var temp;
	for(var i=0; i<arr.length;i++)
	{
	    for(var j=i+1;j<arr.length;j++)
	    {
	         if(arr[i].storageMoney>arr[j].storageMoney)
	          {
	             temp=arr[i];
	             arr[i]=arr[j];
	             arr[j]=temp;
	           }
	     }
	}
	
	return arr;
}

/**
 * optionJson 为操作条件输入框的值
 */
function countMinxResult(optionJson){
	
	var result=sortRowsData();//这里是选择的基础数据
	$tableDb=$('#tableCond');
	var  dunshu;
	var tiji;
    var jieguo;
    var obj=new Object();
	for(var i=0;i<result.length;i++){//循环基础数据
		console.log(result[i].groupName);
	for(var j=0;j<optionJson.length;j++){//开始循环条件
		//根据条件ID获得条件属性字段,quaitid为指标ID
		var row=$tableDb.bootstrapTable('getRowByUniqueId', optionJson[j].quaitid);
		switch(row.fdName){
		case'MIXSULFURCONT'://硫含量
			
			dunshu1=optionJson[j].cost/result[i].sulfurCon;//根据硫含量计算最大吨数，如果是条件<号，如果是>号表示最小吨数
			
	        console.log('硫含量吨数限制='+dunshu1);
			break;
		case'VISCOSITY'://粘度
			console.log('粘度='+optionJson[j].optioinCode+optionJson[j].cost);
			break;
		case 'MIXHOT'://净热值
			var val=optionJson[j].cost;//这里是条件设定的上线
			var  dunshu2=val/result[i].nethot;//这里是返回的质量百分比 乘以100为实际吨数，我们这里都按照100吨计算
			
			console.log('净热值吨数='+dunshu2);
			break;
		case'MIXINGDEN'://密度
			//console.log('要求混合后密度'+optionJson[j].optioinCode+optionJson[j].cost);
			//tiji=dunshu/result[i].md;// 这里计算单个体积
			var tijibaifenbi=optionJson[j].cost/result[i].md;//计算体积百分比
			
			 console.log('混合后密度吨数='+tijibaifenbi*result[i].md);
			break;
		default:
				break;
		}
	}
	}
}

 
function getSelectTab(){
	var rows=$('#tableDb').bootstrapTable('getSelections');
	 
	var basicId='';
	var ids=new Array();
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		 
	    var pst=$("#conditFrm").serializeArray();
	     var resultJson=$.frmtJson(pst,3);
	     countMinxResult(resultJson);
	     
		 $.ajax({
			 url:'/purchase/groupBasic/result/'+ids,
			 type :'post',
			 //dataType: "json",
			 contentType: "application/json; charset=utf-8",  
			 data:JSON.stringify(resultJson),//JSON.stringify([{quaitid:1,optioinCode:'<=',cost:200},{quaitid:2,optioinCode:'<=',cost:230},{quaitid:3,optioinCode:'<=',cost:240}]),//JSON.stringify($("#conditFrm").serializeArray()),
			 success:function(docnum){
				 alert('计算成功'+docnum);
				 $('#resultTb').bootstrapTable('refresh', {url: '/purchase/groupBasic/result/count/'+docnum});  
			 },error:function(data,msg,xml){
				 alert('计算异常'+data+'--'+msg);
			 }
		 }); 
	}
}

 