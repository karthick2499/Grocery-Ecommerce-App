/*!
    * Start Bootstrap - SB Admin v7.0.5 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2022 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});


function addOrder()
{
	
	var now = new Date();
	var date = moment(now).format('YYYY-MM-DD');
    var deliveryDate = moment().add(10, 'days').format('YYYY-MM-DD');
    var orderdate=date;
    var customerId=parseInt(sessionStorage.getItem("customerId"));
     $.ajax({
    url: 'http://localhost:9090/api/grocery/v1/addorder',
    dataType: 'json',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify(  
		{
		   "orderDate": orderdate,
		   "customer":{
		   "customerId":customerId
		}			 
}),
    processData: true,
    success: function( data, textStatus, jQxhr ){
      
       console.log(data);
       orderId=parseInt(data.orderId);
       sessionStorage.setItem("orderId",orderId);
       addTransaction();
         addDelivery();
      addOrderedProducts();
    location.href="/order-confirm";
       
    },
    error: function( jqXhr, textStatus, errorThrown ){
    
        console.log( errorThrown );
    }
});
    	
}



function addTransaction()
{
	var now = new Date();
	var date = moment(now).format('YYYY-MM-DD');
    var deliveryDate = moment().add(10, 'days').format('YYYY-MM-DD');
    var transactionDate=date; 
    var  transactionAmount=$("#paymentAmount").val();
    var customerId=parseInt(sessionStorage.getItem("customerId"));
      $('input[id="debit-card"]:checked')
    {
    
     transactionMode="Online - Debit Card";
     
    }
      $('input[id="cash-on-delivery"]:checked')
    {
      transactionMode="Offline - Cash On Delivery";
      
    }
     
     	 $.ajax({
    url: 'http://localhost:9090/api/grocery/v1/addtransaction',
    dataType: 'json',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify(  
{
   "transactionDate": transactionDate,
   "transactionAmount":transactionAmount,
   "transactionMode":transactionMode, 
   "customer":{
	"customerId":customerId
   },
   "order":{
	"orderId":orderId
   }
			 
}  ),
    processData: false,
    success: function( data, textStatus, jQxhr ){
       console.log( data);
       sessionStorage.setItem("transactionId",data.transactionId);
    },
    error: function( jqXhr, textStatus, errorThrown ){
        console.log( errorThrown );
    }
});
	
	
}

function addDelivery()
{
	    var customerId=parseInt(sessionStorage.getItem("customerId"));
	     var deliveryDate = moment().add(10, 'days').format('YYYY-MM-DD');
	
	$.ajax({
    url: 'http://localhost:9090/api/grocery/v1/adddelivery',
    dataType: 'json',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify(
{
"customer":{
  "customerId":customerId

},
"deliveryDate":deliveryDate,
"deliveryStatus": "In-process",
"delivaryLocation":sessionStorage.getItem("customerAddress")
}
  
 ),
    processData: false,
    success: function( data, textStatus, jQxhr ){
       sessionStorage.setItem("deliveryId",data.deliveryId);
       console.log( data);
    },
    error: function( jqXhr, textStatus, errorThrown ){
        console.log( errorThrown );
    }
});
}


function addOrderedProducts()
{
	
if(localStorage.length>1)
  {  
  for(var i in localStorage)
  {
  if(i!="lastindex")
  { //alert('inside');
    orderId=parseInt(sessionStorage.getItem("orderId")); 
   var product=JSON.parse(localStorage.getItem(i));
   //alert(product.productName+" "+product.productPrice+" "+product.productQuantity+" "+orderId);
    $.ajax({
    url: 'http://localhost:9090/api/grocery/v1/addorderedproducts',
    dataType: 'json',
    type: 'post',
    contentType: 'application/json',
    data: JSON.stringify(  
	{
	 "productName":product.productName,
	 "productPrice":product.productPrice,
	 "productQuantity":product.productQuantity,
	 "order":
	 {
	     "orderId":orderId
	 }
 
} ),
    processData: false,
    success: function( data, textStatus, jQxhr ){
       console.log( data);
       location.href="/order-confirm"; 
    },
    error: function( jqXhr, textStatus, errorThrown ){
        console.log( errorThrown );
    }
});
	
}
}
}
}



