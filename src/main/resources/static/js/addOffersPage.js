// addOffersPage.js

document.addEventListener('DOMContentLoaded', function(){


 updateModels('brand', 'model', '/offers/brands/' );
 const modelSelect = document.getElementById('model');
 if(modelSelect.value){
    updateYearOptions(modelSelect.value);
 }


 const fileInput = document.getElementById('img');
 const fileNameDisplay = document.getElementById('fileNameDisplay');
 fileInput.addEventListener('change', function() {
     if(this.files.length > 0) {
         fileNameDisplay.textContent = `Selected file: ${this.files[0].name}`;
     } else {
         fileNameDisplay.textContent = '';
     }
 });




});

document.addEventListener('DOMContentLoaded', function(){
   

   
    const fileInput = document.getElementById('img');
    const fileNameDisplay = document.getElementById('fileNameDisplay');
    fileInput.addEventListener('change', function() {
        if(this.files.length > 0) {
            fileNameDisplay.textContent = `Selected file: ${this.files[0].name}`;
        } else {
            fileNameDisplay.textContent = '';
        }
    });
});




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

                updateYearOptions();
            })
            .catch(error => console.error('Error fetching models:', error));
    });

    modelSelect.addEventListener('change', function(){
        updateYearOptions(this.value);
    });
}

export function updateYearOptions(selectedModel){
  
    if (!selectedModel) {
        return;
    }
  



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
    
}