import axios from 'axios';



/* https://maps.googleapis.com/maps/api/place/findplacefromtext/output?parameters

Need to find location first.

input
The text string on which to search, for example: "restaurant" or "123 Main Street". This must be a place name, address, or category of establishments. Any other types of input can generate errors and are not guaranteed to return valid results. The Places API will return candidate matches based on this string and order the results based on their perceived relevance.

inputtype
The type of input. This can be one of either textquery or phonenumber.

fields=photo

Example: https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Museum%20of%20Contemporary%20Art%20Australia&inputtype=textquery&fields=photo&key=AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c

input = if in google map, then m.address 

then get photo reference

Returned JSON object:
candidates.photos.photo_reference
*/

//https://maps.googleapis.com/maps/api/place/photo?parameters


// photo_reference
// A string identifier that uniquely identifies a photo. Photo references are returned from either a Place Search or Place Details request.


export default {
    data() {
        return {
            apiKey: 'AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c'
        }
    },
    getPhotoReference(address){
        return axios.get(`https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=${address}&inputtype=textquery&fields=photo&key=${this.apiKey}`)
    },
    getPhotoReferenceDefault(){
        return axios.get('https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Museum%20of%20Contemporary%20Art%20Australia&inputtype=textquery&fields=photo&key=AIzaSyCGANmXOYKLmKzG6N46k5oEr7MBWy01C2c')
    }
}