-----------
## Details

The api that should be used to get the weather data:

- This API returns the WOEID of the city (${citi} is the parameter)
```https://www.metaweather.com/api/location/search/?query=${city}```

- This API returns the weather for the WOEID of the previous service, in case there's more than one value returned please consider the most recent one:
``` https://www.metaweather.com/api/location/${woeid}/```

More info about these services can be found on:
[metaweather](https://www.metaweather.com/api/)
