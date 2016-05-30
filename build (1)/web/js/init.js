/**
 * 
 */

$(document).ready(function(){
	
    // Show sideNav
    $('.button-collapse').sideNav('show');
    
    // Hide sideNav
    $('.button-collapse').sideNav('hide');
	
    $('.scrollspy').scrollSpy();
    
    $('.tabs-wrapper').pushpin({ top: $('.tabs-wrapper').offset().top });

  });
