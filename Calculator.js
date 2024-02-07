function append(value) {
    document.getElementById('display').value += value;
}

function deleteLastChar() {
    var display = document.getElementById('display');
    display.value = display.value.slice(0, -1);
}

function clearDisplay() {
    document.getElementById('display').value = '';
}

function calculate() {
    try {
        var result = eval(document.getElementById('display').value);
        document.getElementById('display').value = result;
    } catch (error) {
        document.getElementById('display').value = 'Error';
    }
}

function percentage() {
    var display = document.getElementById('display');
    var value = parseFloat(display.value);
    if (!isNaN(value)) {
        display.value = value / 100;
    }
}
