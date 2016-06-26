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
    
    $("#BotaoAdicionar").click(function(){
        $("#SessaoIncluir").show();
    });
    
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      opacity: .5, // Opacity of modal background
      in_duration: 300, // Transition in duration
      out_duration: 200, // Transition out duration
    }
  );
        
    $('select').material_select();

  });
