# API Framework Demo
  
## Background

This project is an example framework for API testing using Java and REST-assured, using Azure Key vault as a secret store. The project also contains an Azure DevOps pipeline that builds the project and runs the tests.

This helps us meet our vision of testing APIs before GUIs, and to use the best tools available.  

This project is intended to be cloned or used as an exemplar for new projects where API testing is required.

## API Under Test

This project uses the on-line JSONPlaceholder API as an example API to test. The path is held in an Azure Key Vault.

[JSONPlaceholder]([https://jsonplaceholder.typicode.com/)

## Usage

 The Azure DevOps pipeline generates the `application.properties` file that contains the following Azure Key Vault information:

    * azure.keyvault.uri - Specifies the URI from when you created your key vault.
    * azure.keyvault.client-id - Specifies the appId GUID from when you created your service principal.
    * azure.keyvault.client-key - Specifies the password GUID from when you created your service principal.

The pipeline variables will need to be updated with the actual values, retaining the same parameter names:

    * KeyVault.Uri
    * KeyVault.ClientId
    * KeyVault.ClientKey

## Technologies  
  
The project uses:
* Java 8  
* Spring  
* Maven  
* REST-assured  
* AssertJ  
  
## Contributing  
  
Contributions welcome! It may be better to speak to the UKHO test leads before submitting a Pull Request to avoid spending time on something that may not be required :smiley:  
  
## Licence  
[MIT © UKHO](LICENCE)
