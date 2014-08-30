# bike-server

REST service for project [bike](https://github.com/pieterprovoost/bike)

## Usage

```test
http://127.0.0.1:8080/bike-server/api/path?from=veldegem&to=brugge
```

```json
{
  "path":[
    {
      "distance":0,
      "number":"91"
    },
    {
      "distance":4037.4899899941297,
      "number":"94"
    },
    {
      "distance":7093.21068729637,
      "number":"96"
    },
    {
      "distance":7866.235758100822,
      "number":"97"
    },
    {
      "distance":9574.42517681931,
      "number":"99"
    },
    {
      "distance":14986.854497563188,
      "number":"6"
    },
    {
      "distance":15496.913133919294,
      "number":"7"
    },
    {
      "distance":17335.314936786315,
      "number":"4"
    },
    {
      "distance":18799.676809312583,
      "number":"1"
    },
    {
      "distance":20438.27844653021,
      "number":"62"
    }
  ]
}
```

