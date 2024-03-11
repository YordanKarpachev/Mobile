//index.js





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

function updateModels(brandSelectId, modelSelectId, endpointBase) {
  

  
  
  const brandSelect = document.getElementById(brandSelectId);
  const modelSelect = document.getElementById(modelSelectId);

  brandSelect.addEventListener('change', function () {
      const selectedBrand = this.value;

      const endpoint = `${endpointBase}${encodeURIComponent(selectedBrand)}/models`;

      fetch(endpoint)
          .then(response => response.json())
          .then(models => {
              modelSelect.innerHTML = '<option value="">- Select a model -</option>';
              models.forEach(model => {
                  let option = document.createElement('option');
                  option.value = model;
                  option.textContent = model;
                  modelSelect.appendChild(option);
              });

                  updateYear();
          })
          .catch(error => console.error('Error fetching models:', error));
  });
}

function updateYear(){
  const modelSelect = document.getElementById('model');

  modelSelect.addEventListener('change', function(){
  
  const selectedModel = modelSelect.value;
  


  fetch(`/api/getModelStartYear/${encodeURIComponent(selectedModel)}`)

 
      .then(response => response.json())
      .then(data => {

       
          const currentYear = new Date().getFullYear();
          const yearSelect = document.getElementById('year');
          yearSelect.innerHTML = '<option value="">- Select a year -</option>';
          
          for(let year = data ; year <= currentYear ;year++){
              let option = document.createElement('option');
              option.value = year;
              option.text = year;
              yearSelect.appendChild(option)
          }


      })

      .catch(error => console.error('Error fetching model start year:', error));
  
})
}
