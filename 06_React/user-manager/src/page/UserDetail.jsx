import React from "react"
import { useNavigate, useParams } from "react-router-dom"
import { useUsers } from "../components/UserContext";

export const UserDetail = () => {
    const { id } = useParams();
    const { users } = useUsers(); 
    const navigate = useNavigate();
    const userId = Number(id); 

    const user = users.find(u=>u.id === userId);
    
    return(
        <div>
            <p>이름 : {user.name}</p>
            <p>나이 : {user.age}</p>
            <p>상태 : {user.status}</p>
            <button onClick={() => {navigate('/')}}>뒤로가기</button>
        </div>
    )
}

export default UserDetail