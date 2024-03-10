//index.js

import { updateModels , updateYear} from "./common.js";



document.addEventListener('DOMContentLoaded', function(){
    updateModels('brand', 'model', '/offers/brands/');

document.getElementById('brand').addEventListener('change', updateOffersCount);
document.getElementById('model').addEventListener('change', updateOffersCount);
  document.getElementById('year').addEventListener('change', updateOffersCount);
  

})





function updateOffersCount(){
   const brand =  document.getElementById('brand');
    const model = document.getElementById('model');
    const year = document.getElementById('year');  

    const brandValue = brand.value ==   "brand"     ?  '' : brand.value;
    const modelValue = model.value ==   "Modell"    ?  '' :model.value ;
    const yearValue = year.value   ==   "- Select a year -" ?  '' : year.value;

    const queryParam = new URLSearchParams({
        brand: brandValue,
        model: modelValue,
        year: yearValue
    }).toString();


    const endpoint  = `/api/getOffersCount?${queryParam}`;

    fetch(endpoint)
    .then(response => response.json())
    .then(data => {
        updateSearchBtn(data);
    })
    .catch(error => console.error('Error fetching offers count', error));

}





function updateSearchBtn(data){
  const btn=  document.getElementById('searchBtn');


    btn.textContent= `${data} Cars`;

}

