# Exercise

Your mission, should you choose to accept is to build a service which will receive a request with the name of a city in the world, and you will have to return the temperature of this city in Celsius and Fahrenheit. And should obey the below constraints:

### 1 - You should define the request of the service (explaining why you choose this approach)

Answer: I used the "@RequestParam" annotation because I'm filtering by the name of the city, 
and I'm not searching by id.  

### 2 - You should define the response of the service (explaining why you choose this approach)

Answer: I chose the "@RestController" annotation to produces JSON by default with the jackson serialization, it's only a webservice

### 3 - You should commit your code on git with your account.

Answer: Done

### 4- You should use mainly Java to do this coding.

Answer: Done

### 5 – You should explain the frameworks you used and why you used them.
Answer: 
- I chose Spring Boot Framework because it's easy to use and very mature.
 
- I have created around 20 microservices, most in Spring Boot. 

- It's easy to deploy into Docker containers.

- No XML based configurations. 

- I like it because has a very good documentation, and a lot of tutorials. 

-----------
## Details

The api that should be used to get the weather data is the below:

- This API returns the WOEID of the city that needs to be searched (${citi} is the parameter)
```https://www.metaweather.com/api/location/search/?query=${city}```

- This API returns the weather for the WOEID of the previous service, in case there's more than one value returned please consider the most recent one:
``` https://www.metaweather.com/api/location/${woeid}/```

More info about these services can be found on:
[metaweather](https://www.metaweather.com/api/)