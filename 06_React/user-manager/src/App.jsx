import './App.css'
import { UserProvider } from './components/UserContext';
import UserList from './page/UserList';
import UserDetail from './page/UserDetail';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import UserRegisteration from './page/UserRegistration';

function App() {
  return (
  <BrowserRouter>
    <UserProvider>
      <Routes>
        <Route path='/' element={<UserRegisteration/>}></Route>
        <Route path='/list' element={<UserList/>}></Route>
        <Route path='/list/:id' element={<UserDetail/>}></Route>
        {/* <UserList/>
        <UserRegisteration/> */}
      </Routes>
    </UserProvider>
  </BrowserRouter>
  )
}

export default App
