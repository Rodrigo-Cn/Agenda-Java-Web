function validar(){
    var nome = newNumber.nome.value;
    var telefone = newNumber.phone.value;
    var email = newNumber.email.value;
    if(nome === ""){
        alert("Preencha o campo nome");
        newNumber.nome.focus;
        return false;
    }
    else if(telefone === ""){
        alert("Preencha o campo telefone");
        newNumber.phone.focus;
        return false;
    }
    else{
        alert("Contato Adicionado com Sucesso!")
        document.forms["newNumber"].submit();
    }
}