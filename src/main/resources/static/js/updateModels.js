// updateModels.js
function updateModels(brandSelectId, modelSelectId, endpoint) {
    const brandSelect = document.getElementById(brandSelectId);
    const modelSelect = document.getElementById(modelSelectId);

    brandSelect.addEventListener('change', function () {
        const selectedBrand = this.value;

        fetch(`${endpoint}/${encodeURIComponent(selectedBrand)}`)
            .then(response => response.json())
            .then(models => {
                modelSelect.innerHTML = '<option value="">- Select a model -</option>';
                models.forEach(model => {
                    let option = document.createElement('option');
                    option.value = model;
                    option.textContent = model;
                    modelSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching models:', error));
    });
}

export { updateModels };
