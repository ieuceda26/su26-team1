## Backend API

# Provider API endpoints
Guide:
- GET /api/guides - returns a list of all guides.
- POST /api/guides - adds a new guide. Needs parameters name, email, password, and keyword.
- GET /api/guides/{id} - returns a specific guide by chosen id.
- PUT /api/guides/{id} - edits an already existing guide's parameters.
- DELETE /api/guides/{id} - deletes the specified guide.
- GET /api/guides/search?query={name} - returns guides that match the given name.
- GET /api/guides/keyword-search?keyword={keyword} - returns guides that match the given keyword. 

TourListings:
- GET /api/tour-listings - returns a list of all tour listings.
- POST /api/tour-listings - adds a new tour listing. Needs parameters name, location, description, price, and maxparticipants. Note that price is a double.
- GET /api/tour-listings/{id} - returns a specific tour listing by chosen id. 
- PUT /api/tour-listings/{id} - edits an already existing tour listing's parameters.
- DELETE /api/tour-listings/{id} - deletes the specified tour listing.

