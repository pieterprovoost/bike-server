# bike-server

JAX-RS REST service for finding a shortest path in the Toerisme Vlaanderen cyling network

## Usage

```test
http://127.0.0.1:8080/bike-server/api/path?from=veldegem&to=51.1835521,3.4478647
http://127.0.0.1:8080/bike-server/api/path?from=veldegem&to=brugge
```

### Output

```json
[ {
  "number" : "91",
  "latitude" : 51.10958019727212,
  "longitude" : 3.171134099347152,
  "distance" : 0.0
}, {
  "number" : "94",
  "latitude" : 51.13131306799819,
  "longitude" : 3.181924356765333,
  "distance" : 4037.4899899941297
}, {
  "number" : "96",
  "latitude" : 51.15677177375281,
  "longitude" : 3.176582357385739,
  "distance" : 7093.21068729637
}, {
  "number" : "97",
  "latitude" : 51.15754361475223,
  "longitude" : 3.187036034527933,
  "distance" : 7866.235758100822
}, {
  "number" : "99",
  "latitude" : 51.16664457772408,
  "longitude" : 3.188574464173363,
  "distance" : 9574.42517681931
}, {
  "number" : "6",
  "latitude" : 51.2004849925966,
  "longitude" : 3.215506586187913,
  "distance" : 14986.854497563188
}, {
  "number" : "7",
  "latitude" : 51.204810706232465,
  "longitude" : 3.21309135197607,
  "distance" : 15496.913133919294
}, {
  "number" : "4",
  "latitude" : 51.217036811233136,
  "longitude" : 3.202363723893165,
  "distance" : 17335.314936786315
}, {
  "number" : "1",
  "latitude" : 51.22168298366409,
  "longitude" : 3.221584489627634,
  "distance" : 18799.676809312583
}, {
  "number" : "62",
  "latitude" : 51.22590556719232,
  "longitude" : 3.206321029291346,
  "distance" : 20438.27844653021
} ]
```

