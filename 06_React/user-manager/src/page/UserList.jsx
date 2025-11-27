import React from "react"; 
import {useUsers} from "../components/UserContext"
import {UserCard} from "../style"
import { useNavigate } from "react-router-dom";

export const UserList = () => {
    const { users } = useUsers();
    const navigate = useNavigate();

    const handleDetail = (id) => {
        navigate("/list/${id}");
    }

    return( 
        <div>
            <h2>사용자 목록</h2>
            <div>
                {users.map((user) => ( 
                    <UserCard key={user.id}>
                        <p>이름 : {user.name}</p>
                        <p>나이 : {user.age}</p>
                        <p>상태 : {user.status}</p>
                        <button onClick={() => handleDetail(user.id)}>
                            상세보기
                        </button>
                    </UserCard>
                ))}
            </div>
        </div>
    )
}

export default UserList;
