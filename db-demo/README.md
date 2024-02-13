## Complex demo

Complex demo is used to research the capabilities of the AI tools (ChatGPT) with database arhitecture generation.

### Steps:


1. ChatGPT is given with the information about our project requirements.
2. After the whole model is generated and described in the ER model, ChatGPT is asked to generate DDL script for model creation
    2. Faced problems:
     - assistent by the human because of the SQL order, wrong foreign keys. After the instruction is given that DDL could not be executed, as fix foreign key is dropped which might not be the best solution
3. With the AI generated SQL, model is created using Intellij database tool - ER image exported in image format
4. Because free ChatGPT version (3.5) doesn't support image upload, paid version (4) is used to upload the image to describe the model and write DDL scipt