## Senior-Project-Backend

#### Current Functionality:
- JWT authorization (`/register`, `/authenticate`)
- `/problem`, `/track` endpoints partially implemented

#### TODO Functionality:
- extend the `Problem` class. Fix fields (`Categories: String -> List<String`), (`TestCases: String -> List<Pair<String,String>>`). The problem is the database can not store collections in its table. So, currently, we just store Strings.
- extend the `Track` class
- extend the endpoints base
- etc.

#### Use Postman to use endpoints

#### Important notes
- When you are launching the Main app, you would create new and empty instance of the database. So, you need to launch /register endpoint first and put the token into Authorization header of other endpoints.
- Postman endpoints for testing ease are sent in Telegram
