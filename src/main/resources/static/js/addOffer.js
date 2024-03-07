import { updateModels } from "./updateModels.js";

document.addEventListener('DOMContentLoaded', function(){
    updateModels('brand', 'model','/offers/getModelsForBrand' )
})