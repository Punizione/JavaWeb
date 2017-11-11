var mark1="off";
var mark2="off";

var c_num = 0;

function checkSelect(){
	var movies=document.getElementsByName("movie");	
	var i=0;
	for(i=0;i<movies.length;i++){
		if(movies[i].checked){
			voteform.btnSubmit.disabled=true;
			voteform.submit();
			alert("投票成功！");
			break;
		}
	}
	
	if(c_num == 0)
	     alert("请至少选择一项！");
}

function hideMessage(chk){
	message.innerHTML='';
	message.style.display='none';
    if(chk.checked) c_num ++;
	  else c_num --;
}

function waitload(){
	parent.wait.style.display='none';
	parent.result.style.display='';
}

function waitclick(){
	wait.style.display='';
	result.style.display='none';
}
//在showresult.jsp页面中调用的脚本，用于实现图片显示区域的缩放
function size(){
	var tag1=parent.document.getElementById("resultpic");	//获取父页面(toresult.jsp)中id属性值为“resultpic”的元素（这里为iframe框架）
	if(mark1=="off"){
		mark1="on";
		tag1.height=document.body.scrollHeight;		//将tag1元素的高度设置为showresult.jsp页面的高度，实现放大效果
	}
	else{
		mark1="off";
		tag1.height=350;				//将tag1元素的高度设置为指定值，实现缩小效果
	}
	
	var tag2=parent.parent.document.getElementById("resultpage");	//获取父页面的父页面(main.jsp)中id属性值为“resultpage”的元素（这里为iframe框架）
	if(mark2=="off"){
		mark2="on";
		tag2.height=parent.document.body.scrollHeight;		//将tag2元素的高度设置为showresult.jsp的父页面toresult.jsp的高度，实现放大效果
	}
	else{
		mark2="off";
		tag2.height=450;					//将tag2元素的高度设置为指定值，实现缩小效果
	}
}