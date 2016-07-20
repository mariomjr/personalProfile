function redirecionarPaginaPersonal(){
	window.location="usuarioLogin";
}

function redirecionarPaginaProfile(){
	window.location="usuarioLogin";
}

function redirecionarAgendaPessoal(){
	window.location="personalAgenda.jsp";
}

function redirecionarGaleria(){
	window.location="personalGaleria.jsp";
}

function redirecionarTelefones(){
	window.location="telefones";
}

function removerTelefone(id){
	document.getElementById('action').value = 'remover';
	document.getElementById('idTelefone').value = id;
    document.getElementById('listTelefonesForm').submit();
}