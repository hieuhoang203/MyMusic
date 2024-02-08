import React from "react";
import '../../css/toolbar.css';
import {Link} from "react-router-dom";

function Toolbar() {

    return (
        <div className="standing-menu">
            <div className="toolbar">
                <div className="toolbar-item">
                    <Link to="/">
                        <i className='bx bxs-home'></i>
                        <span>Home</span>
                    </Link>
                </div>
                <div className="toolbar-item">
                    <Link to="/login">
                        <i className='bx bx-search-alt-2'></i>
                        <span>Search</span>
                    </Link>
                </div>
            </div>
            <div className="library">
                hello
            </div>
        </div>
    );
}

export default Toolbar;