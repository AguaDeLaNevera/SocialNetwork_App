import { Routes, Route, Navigate } from 'react-router-dom';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Navigate to="/login" />} />

            <Route path="/login" element={<Login/>} />
            <Route path="/register" element={<Register/>} />
            <Route path="/home" element={<Home/>} />
            <Route path="/profile/:username" element={<Profile/>} />
            <Route path="/chat" element={<Chat/>} />
            <Route path="/chat/:conversationId" element={<Conversation/>} />
            <Route path="/notifications" element={<Notifications/>} />
        </Routes>
    );
}

export default App;