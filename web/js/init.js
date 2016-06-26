/**
 * 
 */

$(document).ready(function () {

    // Show sideNav
    $('.button-collapse').sideNav('show');

    // Hide sideNav
    $('.button-collapse').sideNav('hide');

    $('.scrollspy').scrollSpy();

    $('.tabs-wrapper').pushpin({top: $('.tabs-wrapper').offset().top});

    $(".botao-alterar").click(function () {
        
        var codigo = this.id;
        
        var descricao = $('#descricao-' + codigo).text();
        
        $('#codigo-alterar').val(codigo);
        $('#descricao-alterar').val(descricao);
        
        $('#modal-alterar').openModal('');
    });
    
    $(".botao-excluir").click(function () {
        
        var codigo = this.id;
        
        var descricao = $('#descricao-' + codigo).text();
        
        $('#codigo-excluir').val(codigo);
        $('#descricao-excluir').val(descricao);
        
        $('#modal-excluir').openModal();
    });
    
    //Função que habilita o modal. Deve ser colocado no href o id da div que estiver
    //com a classe .modal-trigger que será aberta por está função.
    $('.modal-trigger').leanModal({
        dismissible: true, // Modal can be dismissed by clicking outside of the modal
        opacity: .5, // Opacity of modal background
        in_duration: 300, // Transition in duration
        out_duration: 200, // Transition out duration
    });
    
    //Habilita o botão de menu do site
    $('.button-collapse').sideNav();
    
    $('select').material_select();

});
