angular.module('appProduct')
	.controller('ProductController', function($scope, $route, $location, productService) {
	
	var vm = this;
	
	vm.products = [];
	vm.product = {};
//	$scope.teste = 'esta ok';
	
	$scope.addProduct = function(product){
		productService.saveProduct(product)
	        .then(function() {
	        	$scope.product = product;
	        	$scope.product = {};
	        	$route.reload();
	        	console.log(product)
	        }, 
	        	function(erro) {
	            	console.log(erro);
	        });
	};
		
	productService.list() 
		.then(function(products) {	
			$scope.products = products;
	}, function(erro) {
		console.log(erro);
	});
	
	$scope.remove = function(product){
		productService.deleteProduct(product.id)
			.then(function() {
				var indiceProduct = $scope.products.indexOf(product);
				$scope.products.splice(indiceProduct, 1);
		},
		function(erro){
			console.log(erro);
		});
	};
	
	$scope.get = function(product){
		console.log('Inside edit');
		productService.getProductById(product.id)
			.then(function(product) {
				$scope.productId = product;
				$scope.flag = 'edit';
		},
		function(erro){
			console.log(erro);
		});
	};
	
//	$scope.get = function(id){
//		console.log('Inside edit');
//		productService.get({id: id},
//			function(data) {
//			$scope.product = data;
//			$scope.flag = 'edit';
//		});
//	};
	
	
	$scope.update = function(){
		console.log('Inside update');
		productService.updateProduct(product)
			.then(function() {
				console.log(product);
				$scope.productId = product.id;
				$scope.product = {};
	        	$route.reload();
	        	$scope.flag = 'update;'
		},
		function(erro){
			console.log(erro);
		});
	};
	
	$scope.nextPage = function(path) {
		$location.path(path);
	}
	
});
