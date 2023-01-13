import React from 'react'
import '../../App.scss'

const Body = ({children}) => {
  return (
    <div  className="body">
      {children}
    </div>
  )
}

export default Body