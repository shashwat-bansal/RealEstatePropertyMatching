# RealEstatePropertyMatching
This java application can be used to get matching properties along in the decreasing order of their match percentage. Match percantage is based on parameters such as budget, distance, number of rooms and bathrooms etc.  
  
Matching Criteria: (Defined in class utilities.MatchingUtility)
Note: Only the properties having match percentage > 40% will be returned.
1. Budget: 
  a.If price of property falls between minimum and maximum budget, it is a 30% match.  
  b.In case either of minimum or maximum is not given, match percent will fall by 1% for every percent of diffence between price and budget, meaning properties with price difference of >= 30% will not be shown.  
  
2.Distance:
  a. If distance is less than 2 miles, it is a 30% match.
  b. Match percentage fill fall linearly till 10 miles. Properties with distance greater than or equal to 10 miles will not be shown.  
  
3. Number of bedrooms and bathrooms:
  a. If the number of bedrooms and bathrooms is under given range, it is a 20 % mach each.
  b. If they differ by 1, they contribute 10% match. Properties with difference in number of bedrooms/bathrooms greater than 1 will not be shown.
  
 
Assumptions:
1. The request has valid values for all parameters.
2. Valid data is present in the database and the data fetch function is implemented.
