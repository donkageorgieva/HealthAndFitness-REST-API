### Health and Fitness REST API
Java Spring Boot

# Endpoints

### GET BMI 
GET https://health-fitness-api.herokuapp.com/bmi (base URL)

##### Parameters (Required) :
weight=double (weight in KG) <br />
height=double (height in CM)

#### Example: 
GET https://health-fitness-api.herokuapp.com/bmi?weight=55&height=165

### GET Calories 
GET https://health-fitness-api.herokuapp.com/calories (base URL)

##### Parameters (Required) :
weight=double (weight in KG)  <br />
height=double (height in CM)  <br />
age=int (age integer value) <br />
gender=char (values 'm' for male  and 'f' for female) <br />
activity=char, values: <br />
'n' = sedentary <br />
's' = lightly active <br />
'm' = moderately active <br />
'l' = very active <br />
'x' = extra active


#### Example: 
GET https://health-fitness-api.herokuapp.com/calories?weight=55&height=165&activity=n&gender=m&age=25
