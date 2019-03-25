application.controller("editCtrl", function($scope, $http, $routeParams, $location){
	var url = "/api/zadaci/" + $routeParams.id;
	var projektiUrl = "/api/projekti";
	
	$scope.projekti = [];
	
	$scope.object = {};
	$scope.object.naziv = "";
	$scope.object.zaduzeni = "";
	$scope.object.procenjenoSati = "";
	$scope.object.opis = "";
	$scope.object.projekatId = "";
	
	var getProjekti = function() {
		$http.get(projektiUrl).then(function success(response){
			$scope.projekti = response.data;
			
			getObject();
		}, function failure(){
			alert("Greska! Dobavljanje Projekti neuspesno");
		});
	}
	
	var getObject = function() {
		$http.get(url).then(function success(response){
			$scope.object = response.data;
		}, function failure(){
			alert("Greska! Resurs nije mogao biti dobavljen");
		});
	}
	getProjekti();
	
	$scope.save = function() {
		$http.put(url, $scope.object).then(function success(response){
			$location.path("/");
		}, function failure(){
				alert("Greska! Izmene neuspesne");
		});
	}
});