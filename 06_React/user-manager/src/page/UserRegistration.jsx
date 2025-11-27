import React,  { useState } from 'react';
import { useUsers } from '../components/UserContext';
import { useNavigate } from 'react-router-dom';

export const UserRegisteration = () => {
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [status, setStatus] = useState('');

    const { addUser } = useUsers();
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        addUser({
            name : name.trim(),
            age : Number(age),
            status : status.trim()
        });

        setName('');
        setAge('');
        setStatus('');
        navigate('/list');
    }

    const handleChangeName = (e) => {
        setName(e.target.value);
    }

    const handleChangeAge = (e) => {
        setAge(e.target.value);
    }

    const handleChangeStatus = (e) => {
        setStatus(e.target.value);
    }

    return(
        <form onSubmit={handleSubmit}>
            <label>이름 : <input type="text" value={name} onChange={handleChangeName}/></label>
            <label>나이 : <input type="number" value={age} onChange={handleChangeAge}/></label>
            <label>상태 :<input type="text"value={status} onChange={handleChangeStatus} /></label>
            <button type="submit">제출</button>
        </form>
    )
}

export default UserRegisteration