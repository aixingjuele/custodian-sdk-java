
English | [中文](README_CN.md)

# Custodian-OpenAPI 



## API Specifications

- API requests use `HMAC` authentication.

- **Pagination** - Query record lists are all divided into pages, Pagination parameters: `page_num` represents the page number, `page_size` represents the size of each page. API `DTO` uniformly returns `total`, `records`.

- **Country** - Two digit country codes, refer to `ISO 3166-1 alpha-2` standards.

- Time management - API requests and responses return a `UNIX` timestamp, unit being **seconds**, in order to avoid issues due to regional time differences.

- Amount management - All API requests and responses are of the `string` data type in order to avoid precision loss.

- All the requests that have a `body` but don't explicitly define a format are of `JSON` type, `Content-Type: application/json`

- API response format standard-

  | Field_Name |  Type  |                         Description                          |
  | :--------: | :----: | :----------------------------------------------------------: |
  |    code    |  int   |          Error code. `0`: Normal, non-`0`: Abnormal          |
  |    msg     | string | `SUCCESS` indicates success, error code indicates and describes failure |
  |   result   | object |                        Result                                |



### HMAC Authentication

The institution first needs to apply for the API `key` and API `secret` that will be used when accessing the API.

| Term                   | Description                                                  |
| ---------------------- | ------------------------------------------------------------ |
| User ID                | User ID is used to indicate the developer account, is used as the user ID |
| API key and API secret | Multiple API key + API secret maintained under a User ID, API key is linked with an application, multiple applications are allowed, each application can apply for API access privileges |

#### Client side implementation process:

1. Compose the data that needs to be signed, including-
   - UNIX timestamp, unit being `milliseconds`: the `request` time stamp 
   - Request method: `HTTP` method
   - Request API key： API Key
   - Complete request path, including the `URL` parameters: request URI
   - If there is a request `body`, the post conversion `string` of the `body` also needs to be added: string representation of the request payload
2. Client side generates the signature using `HMAC_SHA256` based on the data and API secret
3. Set the Authorization header based on the fixed sequence, i.e. the key is `Authorization`, and the value is: ApiKey:request time stamp:signature (linked using colon) 
4. If the server side sets a password when creating the API key and secret, then an Access-Passphrase header needs to be set, i.e., the `key` is `Access-Passphrase`, and the `value` is the password.
5. Client side sends the data, Authorization header, and the Access-Passphrase header (in case there is a fourth step) to the server side, i.e., the final http header sent is as follows:
   - Authorization：ApiKey:request timestamp:signature
   - Access-Passphrase：Your API Secret passphrase


#### How to build the request body string to be signed:

The parameter names of the request body need to be based on the respective `ASCII` values, pair key and value using `=`, and connect multiple key-value pairs using `&` to form a string.

Here is an example `body`-

```json
{
	"ont_id":"did:ont:Ae9ujqUnAtH9yRiepRvLUE3t9R2NbCTZPG",
	"amount":190,
	"to_address":"AUol16ghiT9AtxRDtNeq3ovhWJ5iaY6iyd"
}
```

The payload is converted to-

```java
amount=190&ont_id=did:ont:Ae9ujqUnAtH9yRiepRvLUE3t9R2NbCTZPG&to_address=AUol16ghiT9AtxRDtNeq3ovhWJ5iaY6iyd
```

**Example**

```
origin sign data:1579506853639GET/v1/api/account2917395a08a443778bb65452998c9af8

https://preopenapi.safeoncustodian.com/v1/api/account
Authorization:2917395a08a443778bb65452998c9af8:1579506261997:4SvqRiIUJUSSWRLSeYjBxI4L9T6Mgs21IpieQ8JlEkM=
Access-Passphrase:11111111

{"code":0,"msg":"SUCCESS","result":[{"address":"tb1q07r35czmvuhl28r93qgv02h6t030gcheqd34rs","address_name":"Hot-Wallet-16-BTC","coin_unique_name":"BTC","coin_symbol":"BTC","coin_full_name":"Bitcoin","coin_decimal":8,"deposit_allowed":1,"is_withdrawal_allowed":1,"current_balance":"0.084800000000000000","fee_coin":"BTC","estimated_fee":"0.0001","upper_limit":"10.000000000000000000","lower_limit":"0.010000000000000000"},{"address":"0xa2784b0a79d21fe733d0006bf7facc6ada85f451","address_name":"Hot-Wallet-16-ETH","coin_unique_name":"ETH","coin_symbol":"ETH","coin_full_name":"Ethereum","coin_decimal":18,"deposit_allowed":1,"is_withdrawal_allowed":1,"current_balance":"4.262480000000014912","fee_coin":"ETH","estimated_fee":"0.001","upper_limit":"5.000000000000000000","lower_limit":"1.000000000000000000"},{"address":"0xa2784b0a79d21fe733d0006bf7facc6ada85f451","address_name":"Hot-Wallet-16-ETH","coin_unique_name":"USDT-ERC20","coin_symbol":"USDT-ERC20","coin_full_name":"Ethereum","coin_decimal":6,"deposit_allowed":1,"is_withdrawal_allowed":1,"current_balance":"1895.000000000000000000","fee_coin":"ETH","estimated_fee":"0.001","upper_limit":"900.000000000000000000","lower_limit":"200.000000000000000000"}]}

```