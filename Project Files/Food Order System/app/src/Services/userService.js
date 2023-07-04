import { myAxios } from "./Helper";

export const SignUpAdd = (user) => {
    return myAxios
    .post('/api/v1/users/save',user)
    .then((res) => res.data);
}

export const LoginCheck = (user) => {
    return myAxios
    .post('/api/v1/users/login',user)
    .then((res) => res.data);
}

export const GetUser = (id) => {
    return myAxios
    .get(`/api/v1/users/get${id}`)
    .then((res) => res.data);
}

export const GetAllUsers = () => {
    return myAxios
    .get('api/v1/users/getall')
    .then((res)=>res.data);
}

export const DeleteUSer = (id) =>{
    return myAxios
    .delete(`/api/v1/users/udelete${id}`)
    .then((res) => res.data);
}
