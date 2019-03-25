application.controller("mainCtrl", function($scope, $http, $location){
	var url = "/api/zadaci";
	var projektiUrl = "/api/projekti";
	
	$scope.resource = [];
	$scope.projekti = [];
	
	$scope.page = 0;
	$scope.totalPages = 1;
	
	$scope.searchParams = {};
	$scope.searchParams.projekat = "";
	$scope.searchParams.naziv = "";
	$scope.searchParams.zaduzeni = "";
	
	$scope.ukupnoSati = "";
	var getResource = function() {
		var config = {params: {}};
		
		if ($scope.searchParams.projekat != "") {
			config.params.projekat = $scope.searchParams.projekat;
		}
		
		if ($scope.searchParams.naziv != "") {
			config.params.naziv = $scope.searchParams.naziv;
		}
		
		if ($scope.searchParams.zaduzeni != "") {
			config.params.zaduzeni = $scope.searchParams.zaduzeni;
		}
		
		config.params.page = $scope.page;
		$http.get(url, config).then(function success(response){
			$scope.resource = response.data;
			$scope.totalPages = response.headers("totalPages");
			$scope.ukupnoSati = response.headers("ukupnoSati");
		}, function failure(){
			alert("Greska! Resursi nisu mogli biti dobavljeni");
		});
	}
	getResource();
	
	var getProjekti = function() {
		$http.get(projektiUrl).then(function success(response){
			$scope.projekti = response.data;
		}, function failure(){
			alert("Dobavljanje projekata nije bilo uspesno");
		});
	}
	getProjekti();
	
	$scope.delete = function(id) {
		$http.delete(url + "/" + id).then(function success(response){
			getResource();
		}, function failure(){
			alert("Greska! Resurs nije mogao biti obrisan");
		});
	}
	
	$scope.goToAdd = function() {
		$location.path("/zadaci/add");
	}
	
	$scope.goToEdit = function(id) {
		$location.path("/zadaci/edit/" + id);
	}
	
	$scope.changePage = function(direction) {
		$scope.page = $scope.page + direction;
		getResource();
	}
	
	$scope.search = function() {
		$scope.page = 0;
		getResource();
	}
	
	$scope.reset = function() {
		$scope.searchParams.projekat = "";
		$scope.searchParams.naziv = "";
		$scope.searchParams.zaduzeni = "";
	}
	
	$scope.predji = function(id) {
		$http.post(url + "/" + id + "/predji").then(function success(){
			getResource();
			alert("Prelazak u drugo stanje je uspelo");
		}, function failure(){
			alert("Prelazak u drugo stanje nije uspelo");
		});
	}
});