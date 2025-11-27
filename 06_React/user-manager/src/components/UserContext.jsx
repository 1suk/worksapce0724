import React, {useContext, useState} from 'react'

const UserContext = React.createContext();

export const UserProvider = ({children}) => {
    const initialUsers = [
        {
            id : 1,
            name : "공석준",
            age : 25,
            status : "Online"
        },
        {
            id : 2,
            name : "최호승",
            age : 25,
            status : "Offline"
        }

    ]

    const [users, setUsers] = useState(initialUsers);

    const addUser = (newUser) => {
        const userWithId = {
            id : Date.now(),
            name : newUser.name,
            age : newUser.age,
            status : newUser.status
        };
    
        setUsers([...users, userWithId]);
        console.log(users);
    }

    return <UserContext.Provider value={{users, addUser}}>
       {children}
    </UserContext.Provider>
};

export const useUsers = () => {
    return useContext(UserContext);
}
