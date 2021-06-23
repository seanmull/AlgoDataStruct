class FontChooser extends React.Component {

    constructor(props) {
	super(props);
        this.state = {hidden : true, 
                      checked : (this.props.bold == 'true'), 
                      bold: (this.props.bold == 'true'), 
                      size : Number(this.props.size), 
                      color: 'black'}; 
    }
    
    handleClick(){
        this.setState({hidden : !this.state.hidden});
        this.setState({size: Number(errorChecking(this.state.min,this.state.max,this.state.size))});
    }
    
    onChange(){
        this.setState({checked :!this.state.checked, 
                       bold : !this.state.bold});
    }
    
    incrementCount () { 
        if(Number(this.state.size) >= Number(this.props.max)-1){
          this.setState({size: Number(this.props.max)});
          this.setState({color: 'red'});
        }else{
          this.setState({size: Number(this.state.size) + 1 });
          this.setState({color: 'black'});
        }
    }
    
    decrementCount () {
        if(Number(this.state.size) <= Number(this.props.min)+1){
          this.setState({size: Number(this.props.min)});
          this.setState({color: 'red'});
        }else{
          this.setState({size: Number(this.state.size) - 1 });
          this.setState({color: 'black'});
          
        }
    }
    
    onDoubleClick(){
        this.setState({size: Number(this.props.size)});
    }
    
    render() {
	var bold = this.state.bold ? 'bold' : 'normal' ;
        return(
	       <div>
	       <input type="checkbox"  hidden={this.state.hidden} checked={this.state.checked} id="boldCheckbox"  onChange={this.onChange.bind(this)}/>
	       <button id="decreaseButton" onClick={this.decrementCount.bind(this)} hidden={this.state.hidden}>-</button>
	       <span id="fontSizeSpan" onDoubleClick={this.onDoubleClick.bind(this)} style={{fontWeight:bold, color:this.state.color, fontSize:this.state.size}} hidden={this.state.hidden}>{this.state.size}</span>
	       <button id="increaseButton" onClick={this.incrementCount.bind(this)} hidden={this.state.hidden}>+</button>
               <span  id="textSpan" onDoubleClick={this.onDoubleClick.bind(this)} style={{fontWeight:bold, color:this.state.color, fontSize:this.state.size}} onClick={this.handleClick.bind(this)}>{this.props.text}</span>
	       </div>
               
	);
    }
}

function errorChecking(min, max, size){
    if(min < 0){
        return 1;
    }else if(min > max || size < min){
        return min;
    }else if(size > max){
        return size;
    }else{
        return size;
    }
}
