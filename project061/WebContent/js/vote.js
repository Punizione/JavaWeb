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
			alert("ͶƱ�ɹ���");
			break;
		}
	}
	
	if(c_num == 0)
	     alert("������ѡ��һ�");
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
//��showresult.jspҳ���е��õĽű�������ʵ��ͼƬ��ʾ���������
function size(){
	var tag1=parent.document.getElementById("resultpic");	//��ȡ��ҳ��(toresult.jsp)��id����ֵΪ��resultpic����Ԫ�أ�����Ϊiframe��ܣ�
	if(mark1=="off"){
		mark1="on";
		tag1.height=document.body.scrollHeight;		//��tag1Ԫ�صĸ߶�����Ϊshowresult.jspҳ��ĸ߶ȣ�ʵ�ַŴ�Ч��
	}
	else{
		mark1="off";
		tag1.height=350;				//��tag1Ԫ�صĸ߶�����Ϊָ��ֵ��ʵ����СЧ��
	}
	
	var tag2=parent.parent.document.getElementById("resultpage");	//��ȡ��ҳ��ĸ�ҳ��(main.jsp)��id����ֵΪ��resultpage����Ԫ�أ�����Ϊiframe��ܣ�
	if(mark2=="off"){
		mark2="on";
		tag2.height=parent.document.body.scrollHeight;		//��tag2Ԫ�صĸ߶�����Ϊshowresult.jsp�ĸ�ҳ��toresult.jsp�ĸ߶ȣ�ʵ�ַŴ�Ч��
	}
	else{
		mark2="off";
		tag2.height=450;					//��tag2Ԫ�صĸ߶�����Ϊָ��ֵ��ʵ����СЧ��
	}
}