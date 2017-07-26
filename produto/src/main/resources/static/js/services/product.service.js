'use strict';

angular.module('appProduct')
    .factory('productService', productService);

productService.$inject = ['$log', '$resource'];

function productService($log, $resource) {
	/*
	 * id: '@id' - segundo parametro é um mapeando de obj no endpointsempre q for executado
	 */
    var resource = $resource('/product/rest/products/:id', {id: '@id'}, {
//    	get: { method: 'GET'}, 
    	update: { method: 'PUT' }
    });

    var service = {
        list: list,
        getProductById: getProductById,
        saveProduct: saveProduct,
        deleteProduct: deleteProduct,
        updateProduct: updateProduct
    };

    return service;
    //List All
    function list() {
        return resource.query({}, '',
            function(data) {
                return data;
            },
            function(error) {
                $log.error(error);
            }
        ).$promise;
    }
    //Save
    function saveProduct(data) {
        return resource.save([], data,
            function() {},
            function(error) {
                $log.error(error);
            }
        ).$promise;
    }
    //Get ID
    function getProductById(id) {
		return resource.get({id : id},
			function(id) {
				return id;
		},
		    function(error) {
		    	$log.error(error);
		    }
		).$promise;
	}
    //Update
    function updateProduct() {
    	return resource.update([], data,
    		function() {},
    		function(error) {
    			$log.error(error);
    		}
    	).$promise;
    }
    //Delete
    function deleteProduct(id) {
    	return resource.delete({id : id},
    		function() {},
    		function(error) {
    			$log.error(error);
			}
    	).$promise;
	}
};