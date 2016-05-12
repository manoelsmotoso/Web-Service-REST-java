function Usuario(id,nome,email,senha,endereco,lat,lng,tipoUsuario){
	return {
		_id : id,
        nome : nome,
        email : email,
        password : senha,
        telefone : telefone",
        celular :celular,
        endereco :endereco,
        tipoUsuario : tipoUsuario,
        coordenada : [lat,lng]
		}

}


 function Endereco(logradouro, cep){
	return {
		logradouro : logradouro ,
        cep : cep
		}
}	



function Usuario($scope){
	return {
		_id : $scope.usuario.id,
        nome : $scope.usuario.nome,
        email : $scope.usuario.email,
        password : $scope.usuario.senha,
        telefone : $scope.usuario.telefone",
        celular :$scope.usuario.celular,
        endereco :$scope.usuario.endereco,
        tipoUsuario : $scope.usuario.tipoUsuario,
        coordenada : [$scope.usuario.lat,$scope.usuario.lng]
		}

}
