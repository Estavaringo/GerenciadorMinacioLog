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
    
    $(".botao-alterar-job").click(function () {

        var codigo = this.id;

        var descricao = $('#descricao-' + codigo).text();
        var ecalc = $('#ecalc-' + codigo).text();
        var os = $('#os-' + codigo).text();
        var valor = $('#valor-' + codigo).text();
        var bv = $('#bv-' + codigo).text();
        var bvAgencia = $('#bv-agencia-' + codigo).text();
        var bvProdutor = $('#bv-produtor-' + codigo).text();
        var observacao = $('#observacao-' + codigo).text();

        $('#codigo-alterar').val(codigo);
        $('#descricao-alterar').val(descricao);
        $('#ecalc-alterar').val(ecalc);
        $('#os-alterar').val(os);
        $('#valor-alterar').val(valor);
        $('#bv-alterar').val(bv);
        $('#bv-agencia-alterar').val(bvAgencia);
        $('#bv-produtor-alterar').val(bvProdutor);
        $('#observacao-alterar').val(observacao);

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


    $('#select-cliente').on('change', function () {

        var descricaoFaturamento = $('#select-cliente').text();
        var idFaturamento = $('#select-cliente select option[value="' + descricaoFaturamento + '"]').attr('id');

        $("#faturamento-select").val(idFaturamento);
    });


    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });
    
    $(".dropdown-button").dropdown({
      inDuration: 300,
      outDuration: 225,
      constrain_width: true, // Does not change width of dropdown to that of the activator
      hover: true, // Activate on hover
      gutter: 0, // Spacing from edge
      belowOrigin: true, // Displays dropdown below the button
      alignment: 'right' // Displays dropdown with edge aligned to the right of button
    }
  );
    
});
