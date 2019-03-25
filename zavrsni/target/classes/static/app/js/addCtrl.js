application.controller("addCtrl", function($scope, $http, $routeParams, $location){
	var url = "/api/zadaci";
	var projektiUrl = "/api/projekti";
	
	$scope.projekti = [];
	
	var getProjekti = function() {
		$http.get(projektiUrl).then(function success(response){
			$scope.projekti = response.data;
		}, function failure(){
			alert("Dobavljanje projekata nije uspelo");
		});
	}
	getProjekti();
	
	$scope.object = {};
	$scope.object.naziv = "";
	$scope.object.zaduzeni = "";
	$scope.object.procenjenoSati = "";
	$scope.object.opis = "";
	$scope.object.projekatId = "";
	$scope.object.stanjeId = 1;
	
	$scope.add = function() {
		$http.post(url, $scope.object).then(function success(response){
			$location.path("/");
		}, function failure(){
			alert("Greska! Resurs nije mogao biti dodat u aplikaciju");
		});
	}
});