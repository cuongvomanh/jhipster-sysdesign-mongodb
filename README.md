# mymongdbapp

```
curl -X PUT --header 'Content-Type: application/json' -d '{"id":"002", "number":"00002","balance":100}'  'http://localhost:8081/api/bankAccount/bank-accounts'
curl -X POST --header 'Content-Type: application/json' -d '{"accountNumber":"00002","ammount":1}'  'http://localhost:8081/api/bankAccount/withdraw'
```
