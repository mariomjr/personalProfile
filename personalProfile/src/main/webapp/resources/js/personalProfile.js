function redirecionarPaginaPersonal(){
	window.location="usuarioLogin";
}

function redirecionarPaginaProfile(){
	window.location="usuarioLogin";
}

function redirecionarAgendaPessoal(){
	window.location="personalAgenda";
}

function redirecionarGaleria(){
	window.location="personalGaleria.jsp";
}

function redirecionarTelefones(){
	window.location="telefones";
}

function removerTelefone(id){
	document.getElementById("idTelefone").value = id;
	document.getElementById("acaoTela").value = "remover";
    document.getElementById("listTelefonesForm").submit();
}