$(document).ready(function(){
  $(".ui-panelmenu-content").css("display","block"); //shows the menuitems
  $(".ui-panelmenu-header").addClass("ui-state-active"); //sets the submenu header to active state
  $(".ui-icon-triangle-1-e").removeClass("ui-icon-triangle-1-e").addClass("ui-icon-triangle-1-s"); //sets the triangle icon to "expaned" version
});
$(document).ready(function(){
	$("#tableEntrepriseContainer").hide();
	$("#formEntreprise").hide();	
	$("#partic").click(function(){		
		$("#formParticulier").show();
		$("#tableParticulierContainer").show();
		$("#formEntreprise").hide();
		$("#tableEntrepriseContainer").hide();		
	});
	$("#entrep").click(function(){		
		$("#formParticulier").hide()
		$("#tableParticulierContainer").hide();
		$("#formEntreprise").show();
		$("#tableEntrepriseContainer").show();		
	});
});
