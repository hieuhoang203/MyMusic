import React from "react";
import Toolbar from "../menu/Toolbar";

function Home() {
    return (
        <div className="home-page col-md-12">
            <div className="menu col-md-5">
                <Toolbar></Toolbar>
            </div>
            <div className="content col-md-7">
                hello
            </div>
        </div>
    )
}
export default Home;