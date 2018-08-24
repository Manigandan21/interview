Use Case
1. End Point URL: equipment/search?limit={X}  -- GET Request
This API will retrive only number of count we pass in the Query param from the cloudant

2. End Point URL: equipment/{equipmentNumber}  -- GET Request
Here it will retrive the single data from document based on Unique ness. To implement uniqueness I have used the default _id property.

3. End Point URL: equipment/{equipmentNumber}
       Base format: 
{
  "_id": "string",
  "address": "string",
  "contractEndDate": "dd/MM/yyyy",
  "contractStartDate": "dd/MM/yyyy",
  "status": true
       }
Validation :  Start Date will be compared with End date. If End date is before than start date data won’t be inserted and null value will be returned.

