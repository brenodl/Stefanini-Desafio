stefanini.service('util', ['$http', 
                                function($http){
	
	var uri = 'http://' + window.location.host;
	
	/**
	 * Method uri return
	 */
	this.getUri = function(){
		return uri;
	};
	
}]);