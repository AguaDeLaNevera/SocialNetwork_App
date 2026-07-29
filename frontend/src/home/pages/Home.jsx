import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
    const posts = [
        { id: 1, author: 'alice', content: 'Welcome to the network!' },
        { id: 2, author: 'bob', content: 'Hello world' }
    ];

    return (
        <div>
            <header>
                <h1>Home</h1>
                <nav>
                    <Link to="/home">Home</Link> | {' '}
                    <Link to="/chat">Chat</Link> | {' '}
                    <Link to="/notifications">Notifications</Link>
                </nav>
            </header>

            <main>
                <section>
                    <h2>Feed</h2>
                    {posts.map(p => (
                        <article key={p.id} style={{border: '1px solid #ccc', padding: 8, marginBottom: 8}}>
                            <strong>{p.author}</strong>
                            <p>{p.content}</p>
                        </article>
                    ))}
                </section>
            </main>
        </div>
    );
}
