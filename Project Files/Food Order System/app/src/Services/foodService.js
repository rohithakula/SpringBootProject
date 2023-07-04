import { myAxios } from "./Helper";

export const FoodAdd = (user) => {
    return myAxios
    .post('/api/v1/food/fsave',user)
    .then((res) => res.data);
}

// export const LoginCheck = (user) => {
//     return myAxios
//     .post('/api/v1/users/login',user)
//     .then((res) => res.data);
// }

export const GetFood = (id) => {
    return myAxios
    .get(`/api/v1/food/fget${id}`)
    .then((res) => res.data);
}

export const GetAll = () => {
    return myAxios
    .get('api/v1/food/flist')
    .then((res)=>res.data);
}

export const Delete = (id) =>{
    return myAxios
    .delete(`/api/v1/food/fdelete${id}`)
    .then((res) => res.data);
}